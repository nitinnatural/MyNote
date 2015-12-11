// Generated code from Butter Knife. Do not modify!
package com.example.note.util;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DialogColorChooser$$ViewBinder<T extends com.example.note.util.DialogColorChooser> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492973, "field 'color1'");
    target.color1 = finder.castView(view, 2131492973, "field 'color1'");
    view = finder.findRequiredView(source, 2131492974, "field 'color2'");
    target.color2 = finder.castView(view, 2131492974, "field 'color2'");
    view = finder.findRequiredView(source, 2131492975, "field 'color3'");
    target.color3 = finder.castView(view, 2131492975, "field 'color3'");
    view = finder.findRequiredView(source, 2131492976, "field 'color4'");
    target.color4 = finder.castView(view, 2131492976, "field 'color4'");
    view = finder.findRequiredView(source, 2131492977, "field 'color5'");
    target.color5 = finder.castView(view, 2131492977, "field 'color5'");
  }

  @Override public void unbind(T target) {
    target.color1 = null;
    target.color2 = null;
    target.color3 = null;
    target.color4 = null;
    target.color5 = null;
  }
}
