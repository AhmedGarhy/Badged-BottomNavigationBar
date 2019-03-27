package com.badgedbottomnavigationbar;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.LayoutRes;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BadgedBottomNavigationBar extends  BottomNavigationView{
    @LayoutRes int badgeLayoutResId;
    public BadgedBottomNavigationBar(Context context) {
        super(context);
    }

    public BadgedBottomNavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.badgedBottomNavigationBar);
        badgeLayoutResId = a.getResourceId(R.styleable.badgedBottomNavigationBar_badge_layout,-1);
        a.recycle();
    }

    public BadgedBottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * show the badge on the menu item view.
     *
     * @param menuItemIndex
     */
    public void showBadge(int menuItemIndex) {
        android.support.design.internal.BottomNavigationMenuView bottomNavigationView =
                (android.support.design.internal.BottomNavigationMenuView) getChildAt(0);
        View view = bottomNavigationView.getChildAt(menuItemIndex);
        if (view instanceof ViewGroup) {
            //NUMBER_OF_MENU_ITEM_VIEW_CHILDERN_WITHOUT_BADGE
            if (((ViewGroup) view).getChildCount() > 2) {
                return;
            }
        }
        android.support.design.internal.BottomNavigationItemView bottomNavigationItemView =
                (android.support.design.internal.BottomNavigationItemView) view;

        LayoutInflater.from(getContext()).inflate(badgeLayoutResId != -1 ? badgeLayoutResId : R.layout.notification_badge, bottomNavigationItemView,
                true);

    }

    /**
     * this method to remove dot [badge view] if it's already inflated on the menu item.
     *
     * @param menuItemIndex  the menu item index
     */
    public void removeBadge(int menuItemIndex) {
        android.support.design.internal.BottomNavigationMenuView bottomNavigationMenuView =
                (android.support.design.internal.BottomNavigationMenuView) getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(menuItemIndex);
        // check if the badge is already displayed on the icon.
        if (v instanceof ViewGroup) {
            int childCount = ((ViewGroup) v).getChildCount();
            /* this condition to prevent the inflating the badge more than one time on the
             menu item .. because this means that the badge is already inflated before*/
            // 3 is the NUMBER_OF_MENU_ITEM_VIEW_CHILDERN_WITH_BADGE
            if (childCount < 3) return;
        }
        android.support.design.internal.BottomNavigationItemView itemView = (android.support.design.internal.BottomNavigationItemView) v;
        // remove the last child [badge view]
        itemView.removeViewAt(itemView.getChildCount() - 1);
    }

}
