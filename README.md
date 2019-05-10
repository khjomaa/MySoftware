### Packages:
1. ```npm i jwt-decode moment react-navigation-redux-helpers react-redux redux redux-thunk uuid react-native-modal-datetime-picker react-navigation-material-bottom-tabs react-native-paper ```

2. ```npm i -D react-native-port-patcher```

3. [react-native-vector-icons](https://github.com/oblador/react-native-vector-icons)
    - How To Install:
        - ```npm i react-native-vector-icons```
        - ```react-native link react-native-vector-icons```
4. [react-native-elements](https://react-native-training.github.io/react-native-elements/)
    - How To Install:
        - ```npm i react-native-elements```
        
5. [react-navigation](https://reactnavigation.org/)
    - How To install:
        - ```npm i react-navigation```
        - ```npm i react-native-gesture-handler```
        - ```react-native link react-native-gesture-handler```
        - Edit **MainActivity.java** (Under /android/app/src/main/java/com/tripolo/) and add to it the following:
            ```diff
            import com.facebook.react.ReactActivity;
            + import com.facebook.react.ReactActivityDelegate;
            + import com.facebook.react.ReactRootView;
            + import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;
            
            public class MainActivity extends ReactActivity {
            
              @Override
              protected String getMainComponentName() {
                return "Example";
              }
            
            +  @Override
            +  protected ReactActivityDelegate createReactActivityDelegate() {
            +    return new ReactActivityDelegate(this, getMainComponentName()) {
            +      @Override
            +      protected ReactRootView createRootView() {
            +       return new RNGestureHandlerEnabledRootView(MainActivity.this);
            +      }
            +    };
            +  }
            }
            ```

6. [react-native-image-picker](https://github.com/react-native-community/react-native-image-picker)
    - How To Install:
        - ```npm i react-native-image-picker```
        - ```react-native link react-native-image-picker```
        - Add permissions for iOS and Android:
            - iOS:
                - Open project on Xcode
                - Click on Info.plist (Left menu)
                - Click on + sign next to "Information Property List" and add these 3 permissions:
                    1. NSPhotoLibraryUsageDescription
                    2. NSCameraUsageDescription
                    3. NSPhotoLibraryAddUsageDescription
                - Next to each permission enter in the Value col the following: "Permission is needed for uploading images and taking photos"
            - Android:
                - Open AndroidManifest.xml file (android/app/src/main/AndroidManifest.xml)
                - Add the following permissions:
                    1. ```<uses-permission android:name="android.permission.CAMERA" />```
                    2. ```<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>```

7. [react-native-sensitive-info](https://github.com/mCodex/react-native-sensitive-info)
    - How To Install:
        - ```npm i react-native-sensitive-info```
        - ```react-native link react-native-sensitive-info```

8. [react-native-safari-view](https://github.com/naoufal/react-native-safari-view)
    - How To Install:
        - ```npm i react-native-safari-view```
        - This package will be used for [Logging into RN apps with Facebook or Google](https://rationalappdev.com/logging-into-react-native-apps-with-facebook-or-google/)
        - Setting Up Linking
            - Linking allows us to handle incoming requests. By using a special URL Scheme we are able to redirect users from the backend to the mobile app once they were authenticated.
            - For iOS:
                - Find **RCTLinking.xcodeproj** file inside your project’s folder. It’s located in node_modules/react-native/Libraries/LinkingIOS/ folder.
                - Open application in Xcode
                - Drag the file **RCTLinking.xcodeproj** to **Libraries**
                - Click on **AppDelegate.m** file and add to it the following:
                    ```diff
                    /**
                     * Copyright (c) Facebook, Inc. and its affiliates.
                     *
                     * This source code is licensed under the MIT license found in the
                     * LICENSE file in the root directory of this source tree.
                     */
                    
                    #import "AppDelegate.h"
                    
                    + #import <React/RCTLinkingManager.h>
                    #import <React/RCTBridge.h>
                    #import <React/RCTBundleURLProvider.h>
                    #import <React/RCTRootView.h>
                    
                    @implementation AppDelegate
                    
                    + - (BOOL)application:(UIApplication *)application openURL:(NSURL *)url
                    +   sourceApplication:(NSString *)sourceApplication annotation:(id)annotation
                    + {
                    +   return [RCTLinkingManager application:application openURL:url
                    +                       sourceApplication:sourceApplication annotation:annotation];
                    + }
                    + 
                    + - (BOOL)application:(UIApplication *)application continueUserActivity:(NSUserActivity *)userActivity
                    +  restorationHandler:(void (^)(NSArray * _Nullable))restorationHandler
                    + {
                    +   return [RCTLinkingManager application:application
                    +                    continueUserActivity:userActivity
                    +                      restorationHandler:restorationHandler];
                    + }
                    
                    - (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
                    {
                      RCTBridge *bridge = [[RCTBridge alloc] initWithDelegate:self launchOptions:launchOptions];
                      RCTRootView *rootView = [[RCTRootView alloc] initWithBridge:bridge
                                                                       moduleName:@"TriPolo"
                                                                initialProperties:nil];
                    
                      rootView.backgroundColor = [[UIColor alloc] initWithRed:1.0f green:1.0f blue:1.0f alpha:1];
                    
                      self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
                      UIViewController *rootViewController = [UIViewController new];
                      rootViewController.view = rootView;
                      self.window.rootViewController = rootViewController;
                      [self.window makeKeyAndVisible];
                      return YES;
                    }
                    
                    - (NSURL *)sourceURLForBridge:(RCTBridge *)bridge
                    {
                    #if DEBUG
                      return [[RCTBundleURLProvider sharedSettings] jsBundleURLForBundleRoot:@"index" fallbackResource:nil];
                    #else
                      return [[NSBundle mainBundle] URLForResource:@"main" withExtension:@"jsbundle"];
                    #endif
                    }
                    
                    @end
                    
                    ```
                - Click on TriPolo (app name - top left menu)
                - Click on "Info" tab
                - Expand "URL Types"
                - Click on + sign
                - Enter for "Identifier" the following: global.tripolo.TriPolo
                - Enter for "URL Schemes" the following: TriPolo
            - For Android:
                - Open AndroidManifest.xml file (android/app/src/main/AndroidManifest.xml)
                - Add another <intent-filter> like this:
                    ```diff
                    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
                              package="com.tripolo">
                    
                        <uses-permission android:name="android.permission.INTERNET"/>
                        <uses-permission android:name="android.permission.CAMERA"/>
                        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
                    
                        <application
                                android:name=".MainApplication"
                                android:label="@string/app_name"
                                android:icon="@mipmap/ic_launcher"
                                android:roundIcon="@mipmap/ic_launcher_round"
                                android:allowBackup="false"
                                android:theme="@style/AppTheme">
                            <activity
                                    android:name=".MainActivity"
                                    android:label="@string/app_name"
                                    android:configChanges="keyboard|keyboardHidden|orientation|screenSize"
                                    android:windowSoftInputMode="adjustResize">
                    
                                <intent-filter>
                                    <action android:name="android.intent.action.MAIN"/>
                                    <category android:name="android.intent.category.LAUNCHER"/>
                                </intent-filter>
                    
                                + <intent-filter>
                                +     <action android:name="android.intent.action.VIEW"/>
                                +     <category android:name="android.intent.category.DEFAULT"/>
                                +     <category android:name="android.intent.category.BROWSABLE"/>
                                +     <data android:scheme="tripolo" android:host="login"/>
                                + </intent-filter>
                    
                            </activity>
                            <activity android:name="com.facebook.react.devsupport.DevSettingsActivity"/>
                        </application>
                    
                    </manifest>

                    ```
