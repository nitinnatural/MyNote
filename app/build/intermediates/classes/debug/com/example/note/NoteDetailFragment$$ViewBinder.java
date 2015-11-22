// Generated code from Butter Knife. Do not modify!
package com.example.note;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NoteDetailFragment$$ViewBinder<T extends com.example.note.NoteDetailFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492971, "field 'proxyToolbar'");
    target.proxyToolbar = finder.castView(view, 2131492971, "field 'proxyToolbar'");
    view = finder.findRequiredView(source, 2131492970, "field 'llRoot'");
    target.llRoot = finder.castView(view, 2131492970, "field 'llRoot'");
    view = finder.findRequiredView(source, 2131492998, "field 'btnBack'");
    target.btnBack = finder.castView(view, 2131492998, "field 'btnBack'");
    view = finder.findRequiredView(source, 2131493003, "field 'btnDone'");
    target.btnDone = finder.castView(view, 2131493003, "field 'btnDone'");
    view = finder.findRequiredView(source, 2131493001, "field 'btnDelete'");
    target.btnDelete = finder.castView(view, 2131493001, "field 'btnDelete'");
    view = finder.findRequiredView(source, 2131493002, "field 'btnEdit'");
    target.btnEdit = finder.castView(view, 2131493002, "field 'btnEdit'");
  }

  @Override public void unbind(T target) {
    target.proxyToolbar = null;
    target.llRoot = null;
    target.btnBack = null;
    target.btnDone = null;
    target.btnDelete = null;
    target.btnEdit = null;
  }
}
