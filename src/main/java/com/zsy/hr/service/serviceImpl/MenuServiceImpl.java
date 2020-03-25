package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.dto.MenuTree;
import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.dto.UserData;
import com.zsy.hr.domian.po.Menu;
import com.zsy.hr.mapper.MenuMapper;
import com.zsy.hr.service.MenuService;
import com.zsy.hr.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MenuServiceImpl
 * @Description TODO
 * @Date 2020/3/24 15:53
 * @Created by Yinghao.He
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisUtil redisUtils;

    @Override
    public Result getButton(String username) {
        UserData userData=(UserData)redisUtils.get(username);
        List<Integer> hid=new ArrayList<Integer>();
        for(int i=0;i<userData.getRole().size(); i++){
            hid.add( userData.getRole().get(i).getId() );
        }
        List<Menu> menuList  = menuMapper.getMeuButton(hid);

        List<MenuTree> menuTree=new ArrayList<MenuTree>();
        for(int i=0;i<menuList.size();i++){
            MenuTree mt=GetMenu( menuList.get(i) );
            int flag=0;
            for(int j=0;j<menuTree.size();j++){
                if(menuTree.get(j).getId()==menuList.get(i).getParentid() ){
                    flag=1;
                    menuTree.get(j).getChildren().add(mt);
                    break;
                }
            }
            if(menuTree.size()<1||flag==0){
                menuTree.add( FindMenu( menuList.get(i).getParentid() ) );
                menuTree.get(menuTree.size()-1 ).setChildren();
                menuTree.get( menuTree.size()-1 ).getChildren().add(mt);

            }

        }

        return Result.ok(menuTree);
    }

    private MenuTree FindMenu(Integer id){
        return GetMenu( menuMapper.selectByPrimaryKey(id) );
    }

    private MenuTree GetMenu(Menu menu){//将Menu对象转化成MenuTree
        MenuTree mt=new MenuTree();
        mt.setId( menu.getId() );
        mt.setName( menu.getName() );
        mt.setPath( menu.getPath() );
        mt.setComponent( menu.getComponent() );
        mt.setIconcls( menu.getIconcls() );
        mt.setMeta(menu.getKeepalive(),menu.getRequireauth());
        return mt;
    }
}
