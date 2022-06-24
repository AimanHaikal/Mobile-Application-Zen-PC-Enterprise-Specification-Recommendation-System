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

public final class ActivityAddMotherboardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button cancelMotherboardButton;

  @NonNull
  public final EditText editMotherboardCPUSocket;

  @NonNull
  public final EditText editMotherboardFormFactor;

  @NonNull
  public final EditText editMotherboardName;

  @NonNull
  public final EditText editMotherboardPrice;

  @NonNull
  public final Button submitMotherboardButton;

  @NonNull
  public final TextView textAddMotherboard;

  @NonNull
  public final TextView textMotherboardCPUSocket;

  @NonNull
  public final TextView textMotherboardFormFactor;

  @NonNull
  public final TextView textMotherboardName;

  @NonNull
  public final TextView textMotherboardPrice;

  private ActivityAddMotherboardBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button cancelMotherboardButton, @NonNull EditText editMotherboardCPUSocket,
      @NonNull EditText editMotherboardFormFactor, @NonNull EditText editMotherboardName,
      @NonNull EditText editMotherboardPrice, @NonNull Button submitMotherboardButton,
      @NonNull TextView textAddMotherboard, @NonNull TextView textMotherboardCPUSocket,
      @NonNull TextView textMotherboardFormFactor, @NonNull TextView textMotherboardName,
      @NonNull TextView textMotherboardPrice) {
    this.rootView = rootView;
    this.cancelMotherboardButton = cancelMotherboardButton;
    this.editMotherboardCPUSocket = editMotherboardCPUSocket;
    this.editMotherboardFormFactor = editMotherboardFormFactor;
    this.editMotherboardName = editMotherboardName;
    this.editMotherboardPrice = editMotherboardPrice;
    this.submitMotherboardButton = submitMotherboardButton;
    this.textAddMotherboard = textAddMotherboard;
    this.textMotherboardCPUSocket = textMotherboardCPUSocket;
    this.textMotherboardFormFactor = textMotherboardFormFactor;
    this.textMotherboardName = textMotherboardName;
    this.textMotherboardPrice = textMotherboardPrice;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddMotherboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddMotherboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_motherboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddMotherboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cancelMotherboardButton;
      Button cancelMotherboardButton = ViewBindings.findChildViewById(rootView, id);
      if (cancelMotherboardButton == null) {
        break missingId;
      }

      id = R.id.editMotherboardCPUSocket;
      EditText editMotherboardCPUSocket = ViewBindings.findChildViewById(rootView, id);
      if (editMotherboardCPUSocket == null) {
        break missingId;
      }

      id = R.id.editMotherboardFormFactor;
      EditText editMotherboardFormFactor = ViewBindings.findChildViewById(rootView, id);
      if (editMotherboardFormFactor == null) {
        break missingId;
      }

      id = R.id.editMotherboardName;
      EditText editMotherboardName = ViewBindings.findChildViewById(rootView, id);
      if (editMotherboardName == null) {
        break missingId;
      }

      id = R.id.editMotherboardPrice;
      EditText editMotherboardPrice = ViewBindings.findChildViewById(rootView, id);
      if (editMotherboardPrice == null) {
        break missingId;
      }

      id = R.id.submitMotherboardButton;
      Button submitMotherboardButton = ViewBindings.findChildViewById(rootView, id);
      if (submitMotherboardButton == null) {
        break missingId;
      }

      id = R.id.textAddMotherboard;
      TextView textAddMotherboard = ViewBindings.findChildViewById(rootView, id);
      if (textAddMotherboard == null) {
        break missingId;
      }

      id = R.id.textMotherboardCPUSocket;
      TextView textMotherboardCPUSocket = ViewBindings.findChildViewById(rootView, id);
      if (textMotherboardCPUSocket == null) {
        break missingId;
      }

      id = R.id.textMotherboardFormFactor;
      TextView textMotherboardFormFactor = ViewBindings.findChildViewById(rootView, id);
      if (textMotherboardFormFactor == null) {
        break missingId;
      }

      id = R.id.textMotherboardName;
      TextView textMotherboardName = ViewBindings.findChildViewById(rootView, id);
      if (textMotherboardName == null) {
        break missingId;
      }

      id = R.id.textMotherboardPrice;
      TextView textMotherboardPrice = ViewBindings.findChildViewById(rootView, id);
      if (textMotherboardPrice == null) {
        break missingId;
      }

      return new ActivityAddMotherboardBinding((ConstraintLayout) rootView, cancelMotherboardButton,
          editMotherboardCPUSocket, editMotherboardFormFactor, editMotherboardName,
          editMotherboardPrice, submitMotherboardButton, textAddMotherboard,
          textMotherboardCPUSocket, textMotherboardFormFactor, textMotherboardName,
          textMotherboardPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}