// Generated by view binder compiler. Do not edit!
package com.example.zenpcenterprise.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.zenpcenterprise.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddPsuactivityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button cancelPSUButton;

  @NonNull
  public final EditText editPSUFormFactor;

  @NonNull
  public final EditText editPSUName;

  @NonNull
  public final EditText editPSUPrice;

  @NonNull
  public final EditText editWattage;

  @NonNull
  public final Button submitPSUButton;

  @NonNull
  public final TextView textAddPSU;

  @NonNull
  public final TextView textPSUFormFactor;

  @NonNull
  public final TextView textPSUName;

  @NonNull
  public final TextView textPSUPrice;

  @NonNull
  public final TextView textWattage;

  private ActivityAddPsuactivityBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button cancelPSUButton, @NonNull EditText editPSUFormFactor,
      @NonNull EditText editPSUName, @NonNull EditText editPSUPrice, @NonNull EditText editWattage,
      @NonNull Button submitPSUButton, @NonNull TextView textAddPSU,
      @NonNull TextView textPSUFormFactor, @NonNull TextView textPSUName,
      @NonNull TextView textPSUPrice, @NonNull TextView textWattage) {
    this.rootView = rootView;
    this.cancelPSUButton = cancelPSUButton;
    this.editPSUFormFactor = editPSUFormFactor;
    this.editPSUName = editPSUName;
    this.editPSUPrice = editPSUPrice;
    this.editWattage = editWattage;
    this.submitPSUButton = submitPSUButton;
    this.textAddPSU = textAddPSU;
    this.textPSUFormFactor = textPSUFormFactor;
    this.textPSUName = textPSUName;
    this.textPSUPrice = textPSUPrice;
    this.textWattage = textWattage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddPsuactivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddPsuactivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_psuactivity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddPsuactivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cancelPSUButton;
      Button cancelPSUButton = ViewBindings.findChildViewById(rootView, id);
      if (cancelPSUButton == null) {
        break missingId;
      }

      id = R.id.editPSUFormFactor;
      EditText editPSUFormFactor = ViewBindings.findChildViewById(rootView, id);
      if (editPSUFormFactor == null) {
        break missingId;
      }

      id = R.id.editPSUName;
      EditText editPSUName = ViewBindings.findChildViewById(rootView, id);
      if (editPSUName == null) {
        break missingId;
      }

      id = R.id.editPSUPrice;
      EditText editPSUPrice = ViewBindings.findChildViewById(rootView, id);
      if (editPSUPrice == null) {
        break missingId;
      }

      id = R.id.editWattage;
      EditText editWattage = ViewBindings.findChildViewById(rootView, id);
      if (editWattage == null) {
        break missingId;
      }

      id = R.id.submitPSUButton;
      Button submitPSUButton = ViewBindings.findChildViewById(rootView, id);
      if (submitPSUButton == null) {
        break missingId;
      }

      id = R.id.textAddPSU;
      TextView textAddPSU = ViewBindings.findChildViewById(rootView, id);
      if (textAddPSU == null) {
        break missingId;
      }

      id = R.id.textPSUFormFactor;
      TextView textPSUFormFactor = ViewBindings.findChildViewById(rootView, id);
      if (textPSUFormFactor == null) {
        break missingId;
      }

      id = R.id.textPSUName;
      TextView textPSUName = ViewBindings.findChildViewById(rootView, id);
      if (textPSUName == null) {
        break missingId;
      }

      id = R.id.textPSUPrice;
      TextView textPSUPrice = ViewBindings.findChildViewById(rootView, id);
      if (textPSUPrice == null) {
        break missingId;
      }

      id = R.id.textWattage;
      TextView textWattage = ViewBindings.findChildViewById(rootView, id);
      if (textWattage == null) {
        break missingId;
      }

      return new ActivityAddPsuactivityBinding((ConstraintLayout) rootView, cancelPSUButton,
          editPSUFormFactor, editPSUName, editPSUPrice, editWattage, submitPSUButton, textAddPSU,
          textPSUFormFactor, textPSUName, textPSUPrice, textWattage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}