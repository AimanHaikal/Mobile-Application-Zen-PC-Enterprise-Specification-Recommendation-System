// Generated by view binder compiler. Do not edit!
package com.example.zenpcenterprise.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.zenpcenterprise.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ActivityStaffViewMotherboardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  private ActivityStaffViewMotherboardBinding(@NonNull ConstraintLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStaffViewMotherboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStaffViewMotherboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_staff_view_motherboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStaffViewMotherboardBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ActivityStaffViewMotherboardBinding((ConstraintLayout) rootView);
  }
}
