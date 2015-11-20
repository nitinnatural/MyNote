// Generated code from Butter Knife. Do not modify!
package com.example.note;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NoteEditFragment$$ViewBinder<T extends com.example.note.NoteEditFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427464, "field 'btnBack'");
    target.btnBack = finder.castView(view, 2131427464, "field 'btnBack'");
    view = finder.findRequiredView(source, 2131427431, "field 'proxyToolbar'");
    target.proxyToolbar = finder.castView(view, 2131427431, "field 'proxyToolbar'");
    view = finder.findRequiredView(source, 2131427469, "field 'btnDone'");
    target.btnDone = finder.castView(view, 2131427469, "field 'btnDone'");
  }

  @Override public void unbind(T target) {
    target.btnBack = null;
    target.proxyToolbar = null;
    target.btnDone = null;
  }
}
