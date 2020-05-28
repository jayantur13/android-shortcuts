# android-shortcuts
Shortcuts that lands you to an specific activity or fragment to perform a task from outside of an application.Long tap an app to see if it has shortcuts and tap on one to see what it performs.

# Availability
App Shortcuts are available from API Level 25 (Android 7.1) and above 

# Types
We have 3 types of shortcuts available which we can use according to the condition or needs of an application
<ul>
<li><b>Static Shortcuts</b> <i>(covering this one for now)</i></li>
<li><b>Dynamic Shortcuts</b></li>
<li><b>Pinned Shortcuts</b></li>
</ul>

Read more on the docs - https://developer.android.com/guide/topics/ui/shortcuts/creating-shortcuts

# Why I'm making this Repo ?
After searching the topics based Android Shortcuts,I didn't find a complete and clear solution according to my needs.And from reading most of them I'm making this one as a solution to the problem that most of the people face or talk about/ask for help in the forums which is "How can I go to Fragment using Shortcut ?" Well, fragments are attached to an activity.

So to solve this you will need an Activity (Must be in an IntentFilter with intent action MAIN <i>android.intent.action.MAIN</i> and category must be the LAUNCHER <i>android.intent.category.LAUNCHER</i>) i.e your LAUNCHER Activity.

# Static Shortcuts
These are the shortcuts that are created only one time and are static in nature (cannot be changed).To make static shortcuts,you need to make a file in res/xml/shortcuts.xml and then link this file in your AndroidManiest.xml under your LAUNCHER Activity.

<code>
   <!-- AndroidManifest.xml -->
   <activity
            android:name=".OnBoardingActivity"
            android:screenOrientation="portrait"
            android:theme="@style/AppTheme.NoTitleBar"
            tools:ignore="LockedOrientationActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
     <!-- Here you have linked the static shortcuts.xml file -->
            <meta-data android:name="android.app.shortcuts"
                android:resource="@xml/shortcuts" />
        </activity>
  </code>
  
  Check repo,after this.
  
  If this helped you.Rate me.<br/>
  Regards.


