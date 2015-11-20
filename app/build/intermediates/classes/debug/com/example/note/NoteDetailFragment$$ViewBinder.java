// Generated code from Butter Knife. Do not modify!
package com.example.note;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NoteDetailFragment$$ViewBinder<T extends com.example.note.NoteDetailFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427431, "field 'proxyToolbar'");
    target.proxyToolbar = finder.castView(view, 2131427431, "field 'proxyToolbar'");
    view = finder.findRequiredView(source, 2131427437, "field 'llRoot'");
    target.llRoot = finder.castView(view, 2131427437, "field 'llRoot'");
    view = finder.findRequiredView(source, 2131427464, "field 'btnBack'");
    target.btnBack = finder.castView(view, 2131427464, "field 'btnBack'");
    view = finder.findRequiredView(source, 2131427469, "field 'btnDone'");
    target.btnDone = finder.castView(view, 2131427469, "field 'btnDone'");
    view = finder.findRequiredView(source, 2131427467, "field 'btnDelete'");
    target.btnDelete = finder.castView(view, 2131427467, "field 'btnDelete'");
    view = finder.findRequiredView(source, 2131427468, "field 'btnEdit'");
    target.btnEdit = finder.castView(view, 2131427468, "field 'btnEdit'");
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
