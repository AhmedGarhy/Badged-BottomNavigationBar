# Badged-BottomNavigationBar
add two apis to the native [BottomNavigationBar](https://developer.android.com/reference/android/support/design/widget/BottomNavigationView) to **show and hide the badge [dot]** on the each menu item.



xml 
```
<com.badgedbottomnavigationbar.BadgedBottomNavigationBar
        android:id="@+id/navigation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:menu="@menu/navigation" />
```
in your activity/fragment
```
BadgedBottomNavigationBar badgedBottomNavigationBar = findViewById(R.id.navigation);
badgedBottomNavigationBar.showBadge(menuItemIndex);
badgedBottomNavigationBar.removeBadge(menuItemIndex);
```

![screenshots](https://i.ibb.co/C657jTB/Screenshot-20190327-150328.png)



Happy Coding :) 
all PRs are welcomed :)
