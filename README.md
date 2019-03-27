# Badged-BottomNavigationBar
add two apis to the native [BottomNavigationBar](https://developer.android.com/reference/android/support/design/widget/BottomNavigationView) to **show and hide the badge [dot]** on the each menu item.

**How to use it** 
```
<com.badgedbottomnavigationbar.BadgedBottomNavigationBar
        android:id="@+id/navigation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:menu="@menu/navigation" />
```
to **show badege** just call showBadge method with the index of the menu item.
```
badgedBottomNavigationBar.showBadge(menuItemIndex);
```
to **remove the badge** call removeBadge metho with the index of the menu item.
```
badgedBottomNavigationBar.removeBadge(menuItemIndex);
```

=============================================================================


**How to integrate**

**Step 1. Add it in your root build.gradle at the end of repositories:**

```
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2. Add the dependency**
```
dependencies {
	        implementation 'com.github.ahmedewess:Badged-BottomNavigationBar:Tag'
	}

```


![screenshots](https://i.ibb.co/C657jTB/Screenshot-20190327-150328.png)



**Happy Coding :) 
all PRs are welcomed :)**
