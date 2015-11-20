// Generated code from Butter Knife. Do not modify!
package com.example.note.util;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DialogColorChooser$$ViewBinder<T extends com.example.note.util.DialogColorChooser> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427442, "field 'color1'");
    target.color1 = finder.castView(view, 2131427442, "field 'color1'");
    view = finder.findRequiredView(source, 2131427443, "field 'color2'");
    target.color2 = finder.castView(view, 2131427443, "field 'color2'");
    view = finder.findRequiredView(source, 2131427444, "field 'color3'");
    target.color3 = finder.castView(view, 2131427444, "field 'color3'");
    view = finder.findRequiredView(source, 2131427445, "field 'color4'");
    target.color4 = finder.castView(view, 2131427445, "field 'color4'");
    view = finder.findRequiredView(source, 2131427446, "field 'color5'");
    target.color5 = finder.castView(view, 2131427446, "field 'color5'");
  }

  @Override public void unbind(T target) {
    target.color1 = null;
    target.color2 = null;
    target.color3 = null;
    target.color4 = null;
    target.color5 = null;
  }
}
