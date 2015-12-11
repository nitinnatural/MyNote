// Generated code from Butter Knife. Do not modify!
package com.example.note;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NewNoteFragment$$ViewBinder<T extends com.example.note.NewNoteFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492978, "field 'llRoot'");
    target.llRoot = finder.castView(view, 2131492978, "field 'llRoot'");
    view = finder.findRequiredView(source, 2131492979, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131492979, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131493004, "field 'btnDone'");
    target.btnDone = finder.castView(view, 2131493004, "field 'btnDone'");
    view = finder.findRequiredView(source, 2131493001, "field 'btnColor'");
    target.btnColor = finder.castView(view, 2131493001, "field 'btnColor'");
    view = finder.findRequiredView(source, 2131492999, "field 'btnBack'");
    target.btnBack = finder.castView(view, 2131492999, "field 'btnBack'");
    view = finder.findRequiredView(source, 2131492980, "field 'etTitle'");
    target.etTitle = finder.castView(view, 2131492980, "field 'etTitle'");
    view = finder.findRequiredView(source, 2131492981, "field 'etContent'");
    target.etContent = finder.castView(view, 2131492981, "field 'etContent'");
  }

  @Override public void unbind(T target) {
    target.llRoot = null;
    target.mToolbar = null;
    target.btnDone = null;
    target.btnColor = null;
    target.btnBack = null;
    target.etTitle = null;
    target.etContent = null;
  }
}
