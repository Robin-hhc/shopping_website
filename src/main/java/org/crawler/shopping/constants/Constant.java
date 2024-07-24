package org.crawler.shopping.constants;

import org.crawler.shopping.utils.PathUtils;

public class Constant {
    public static final String CODE_200 = "200";//success
    public static final String CODE_500 = "500";//system error
    public static final String NO_RESULT = "510";//no result found
    public static final String CODE_401 = "401";//no authorization
    public static final String TOKEN_ERROR = "401";//token invalid
    public static final String CODE_403 = "403";//process denied
    //file path
    public static final String fileFolderPath = PathUtils.getClassLoadRootPath() + "/file/";
    public static final String avatarFolderPath =  PathUtils.getClassLoadRootPath() + "/avatar/";
}
