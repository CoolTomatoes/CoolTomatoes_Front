// Generated by view binder compiler. Do not edit!
package com.android.hackathon2024_2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.hackathon2024_2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySplashBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView splashSubtitle;

  @NonNull
  public final TextView splashTitle;

  private ActivitySplashBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout main,
      @NonNull TextView splashSubtitle, @NonNull TextView splashTitle) {
    this.rootView = rootView;
    this.main = main;
    this.splashSubtitle = splashSubtitle;
    this.splashTitle = splashTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySplashBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySplashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_splash, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySplashBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.splash_subtitle;
      TextView splashSubtitle = ViewBindings.findChildViewById(rootView, id);
      if (splashSubtitle == null) {
        break missingId;
      }

      id = R.id.splash_title;
      TextView splashTitle = ViewBindings.findChildViewById(rootView, id);
      if (splashTitle == null) {
        break missingId;
      }

      return new ActivitySplashBinding((ConstraintLayout) rootView, main, splashSubtitle,
          splashTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
