// Generated by view binder compiler. Do not edit!
package com.android.hackathon2024_2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.hackathon2024_2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentQuestionListBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final AppCompatButton questionNextBtn;

  @NonNull
  public final RecyclerView rcvQuestion;

  @NonNull
  public final TextView textView30;

  @NonNull
  public final TextView textView31;

  private FragmentQuestionListBinding(@NonNull NestedScrollView rootView,
      @NonNull AppCompatButton questionNextBtn, @NonNull RecyclerView rcvQuestion,
      @NonNull TextView textView30, @NonNull TextView textView31) {
    this.rootView = rootView;
    this.questionNextBtn = questionNextBtn;
    this.rcvQuestion = rcvQuestion;
    this.textView30 = textView30;
    this.textView31 = textView31;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentQuestionListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentQuestionListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_question_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentQuestionListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.question_next_btn;
      AppCompatButton questionNextBtn = ViewBindings.findChildViewById(rootView, id);
      if (questionNextBtn == null) {
        break missingId;
      }

      id = R.id.rcv_question;
      RecyclerView rcvQuestion = ViewBindings.findChildViewById(rootView, id);
      if (rcvQuestion == null) {
        break missingId;
      }

      id = R.id.textView30;
      TextView textView30 = ViewBindings.findChildViewById(rootView, id);
      if (textView30 == null) {
        break missingId;
      }

      id = R.id.textView31;
      TextView textView31 = ViewBindings.findChildViewById(rootView, id);
      if (textView31 == null) {
        break missingId;
      }

      return new FragmentQuestionListBinding((NestedScrollView) rootView, questionNextBtn,
          rcvQuestion, textView30, textView31);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
