package rest;

import dao.entity.OldRouteEntity;
import dao.entity.RouteEntity;
import dao.entity.UserEntity;

import javax.ejb.*;
import java.util.ArrayList;

@Singleton
public class DataContainer {

    private static ArrayList<String> activeTokens = new ArrayList<>();
    private static ArrayList<UserEntity> associatedUsers = new ArrayList<>();
    private static ArrayList<RouteEntity> activeRoutes = new ArrayList<>();

    public static String userToken (UserEntity user, String token) {

        return null;
    }

    private static DataContainer instance = null;
    public static DataContainer getInstance () {
        if (instance == null) {
            instance = new DataContainer();
        }
        return instance;
    }
    private DataContainer () {
    }

    public static boolean checkToken (String token) {
        for (String s : activeTokens) {
            if (s.equals(token)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static void addToken (String s) {
        activeTokens.add(s);
        associatedUsers.add(null);
    }

    public static void addToken(String token, UserEntity userEntity) {
        activeTokens.add(token);
        associatedUsers.add(userEntity);
    }

    public static void addToken(UserEntity userEntity) {
        activeTokens.add(userEntity.getToken());
        associatedUsers.add(userEntity);
    }

    public UserEntity getUserByToken (String token) {
        for (int i = 0; i < activeTokens.size(); i++) {
            if (activeTokens.get(i).equals(token)) {
                return associatedUsers.get(i);
            }
        }
        return null;
    }

    public static void addActiveRoute(RouteEntity ent) {
        activeRoutes.add(ent);
    }

    public static RouteEntity getRoute(String token) {
        for (RouteEntity route : activeRoutes) {
            if (route.getToken().equals(token)) {
                return route;
            }
        }
        return null;
    }
}
