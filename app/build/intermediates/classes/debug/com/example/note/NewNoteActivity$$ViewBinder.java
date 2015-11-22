// Generated code from Butter Knife. Do not modify!
package com.example.note;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NewNoteActivity$$ViewBinder<T extends com.example.note.NewNoteActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492970, "field 'llRoot'");
    target.llRoot = finder.castView(view, 2131492970, "field 'llRoot'");
    view = finder.findRequiredView(source, 2131492971, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131492971, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131493003, "field 'btnDone'");
    target.btnDone = finder.castView(view, 2131493003, "field 'btnDone'");
    view = finder.findRequiredView(source, 2131493000, "field 'btnColor'");
    target.btnColor = finder.castView(view, 2131493000, "field 'btnColor'");
    view = finder.findRequiredView(source, 2131492998, "field 'btnBack'");
    target.btnBack = finder.castView(view, 2131492998, "field 'btnBack'");
  }

  @Override public void unbind(T target) {
    target.llRoot = null;
    target.mToolbar = null;
    target.btnDone = null;
    target.btnColor = null;
    target.btnBack = null;
  }
}
