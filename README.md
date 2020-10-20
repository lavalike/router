# router
> 轻型组件间路由框架

[![Platform](https://img.shields.io/badge/Platform-Android-00CC00.svg?style=flat)](https://www.android.com)
[![](https://jitpack.io/v/lavalike/router.svg)](https://jitpack.io/#lavalike/router)
[![API](https://img.shields.io/badge/API-17%2B-00CC00.svg?style=flat)](https://android-arsenal.com/api?level=17)
[![License](https://img.shields.io/badge/License-Apache%202-337ab7.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)


### 依赖导入

项目根目录

``` gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

模块目录

``` gradle
dependencies {
	implementation 'com.github.lavalike:router:0.0.1'
}
```

### 方法说明

``` java
public class Router {
    public static Router with(Context context);
    public static Router with(Fragment fragment);
    public static void addInterceptor(Interceptor interceptor);
    public Router clearTop();
    public boolean to(String url);
    public boolean toPath(String path);
    public Router setExtras(Bundle bundle);
    public Router setAction(String action);
    public Router addCategory(String category);
    public Router removeCategory(String category);
}

```

### 路由拦截器

``` java
public interface Interceptor {
    /**
     * 全局拦截uri,进行全局修改
     *
     * @param uri uri
     * @return Uri
     */
    Uri before(Uri uri);
    /**
     * 动态修改Router.toPath()中默认的host和Scheme
     *
     * @param context context
     * @param path    path
     * @return Uri
     */
    Uri buildByPath(Context context, String path);
}
```

### 代码示例

**配置Manifest.xml**

``` xml
<activity android:name=".SchemeActivity">
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data android:scheme="@string/default_scheme" />
        <data android:host="@string/default_host" />
        <data android:path="/scheme" />
    </intent-filter>
</activity>
```

**配置拦截器(可选)**

``` java
Router.addInterceptor(new Router.Interceptor() {
    @Override
    public Uri before(Uri uri) {
        return null;
    }

    @Override
    public Uri buildByPath(Context context, String path) {
        return null;
    }
});
```

**跳转**

``` java
Bundle extras = new Bundle();
Router.with(this).setExtras(extras).toPath("/scheme");

or

Router.with(this).setExtras(extras).to("http://www.wangzhen.com/scheme");
```



