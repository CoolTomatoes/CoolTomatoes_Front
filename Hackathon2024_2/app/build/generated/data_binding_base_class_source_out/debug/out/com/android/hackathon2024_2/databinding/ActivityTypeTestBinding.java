// Generated by view binder compiler. Do not edit!
package com.android.hackathon2024_2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.android.hackathon2024_2.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTypeTestBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TabLayout tabLayout2;

  @NonNull
  public final ViewPager2 testViewPager;

  @NonNull
  public final TextView textView;

  private ActivityTypeTestBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageView,
      @NonNull ConstraintLayout main, @NonNull TabLayout tabLayout2,
      @NonNull ViewPager2 testViewPager, @NonNull TextView textView) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.main = main;
    this.tabLayout2 = tabLayout2;
    this.testViewPager = testViewPager;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTypeTestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTypeTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_type_test, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTypeTestBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.tabLayout2;
      TabLayout tabLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (tabLayout2 == null) {
        break missingId;
      }

      id = R.id.test_view_pager;
      ViewPager2 testViewPager = ViewBindings.findChildViewById(rootView, id);
      if (testViewPager == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityTypeTestBinding((ConstraintLayout) rootView, imageView, main, tabLayout2,
          testViewPager, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}