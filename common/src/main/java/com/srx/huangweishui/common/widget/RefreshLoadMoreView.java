package com.srx.huangweishui.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.srx.huangweishui.common.R;

/**
 * Created by huangweishui on 2017/10/16.
 */

public class RefreshLoadMoreView extends LinearLayout {
  private Context context;
  SwipeRefreshLayout srl_main;//
  BaseRecylerview recyler_list;//
  private BaseQuickAdapter baseQuickAdapter;
  private boolean canRefresh = true;//是否开启刷新
  private boolean canLoadMore = true;//是否开启上拉加载

  public RefreshLoadMoreView(Context context) {
    this(context, null);
  }

  public RefreshLoadMoreView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RefreshLoadMoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.context = context;
    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.refreshLoadMoreView);
    if (typedArray != null) {
      canRefresh = typedArray.getBoolean(R.styleable.refreshLoadMoreView_can_refresh, true);
      canLoadMore = typedArray.getBoolean(R.styleable.refreshLoadMoreView_can_loadMore, true);
      typedArray.recycle();
    }
    View view = LayoutInflater.from(context).inflate(R.layout.refresh_load_more_view, this, true);
    srl_main = (SwipeRefreshLayout) view.findViewById(R.id.srl_main);
    recyler_list = (BaseRecylerview) view.findViewById(R.id.recyler_list);
    initRefresh();
    initRecylerView();
  }

  /**
   * 初始化SwipeRefreshLayout
   */
  private void initRefresh() {
    srl_main.setColorSchemeResources(R.color.default_font_categary_color);
    srl_main.setEnabled(canRefresh);
    // 这句话是为了，第一次进入页面的时候显示加载进度条
    srl_main.setProgressViewOffset(false, 0, (int) TypedValue
        .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
            .getDisplayMetrics()));
  }

  /**
   * 初始化recylerview
   */
  private void initRecylerView() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
    recyler_list.setLayoutManager(linearLayoutManager);
  }

  /**
   * RecylerView 设置Manager
   */
  public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
    if (recyler_list != null) {
      recyler_list.setLayoutManager(layoutManager);
    }
  }

  /**
   * 下拉刷新
   */
  public void setRefreshListener(final SwipeRefreshLayout.OnRefreshListener refreshListener) {
    if (srl_main != null) {
      refreshing();
      srl_main.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
          if (refreshListener != null) {
            refreshListener.onRefresh();
          }
        }
      });
    }
  }

  /**
   * 上拉加载
   */
  public void setLoadMoreListener(final BaseQuickAdapter.RequestLoadMoreListener loadMoreListener) {
    if (baseQuickAdapter != null && recyler_list != null) {
      loading();
      baseQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
        @Override
        public void onLoadMoreRequested() {
          if (loadMoreListener != null) {
            loadMoreListener.onLoadMoreRequested();
          }
        }
      }, recyler_list);
      //            baseQuickAdapter.disableLoadMoreIfNotFullPage(recyler_list);//默认第一次加载会进入回调，这里设置第一次不需要回调
    }
  }

  public void setCanRefresh(boolean canRefresh) {
    this.canRefresh = canRefresh;
    if (srl_main != null) {
      srl_main.setEnabled(canRefresh);
    }
  }

  public void setCanLoadMore(boolean canLoadMore) {
    this.canLoadMore = canLoadMore;
    if (baseQuickAdapter != null) {
      baseQuickAdapter.setEnableLoadMore(canLoadMore);
    }
  }

  public void setAdapter(BaseQuickAdapter adapter) {
    if (baseQuickAdapter == null) {
      baseQuickAdapter = adapter;
    }
    if (recyler_list != null) {
      recyler_list.setAdapter(adapter);
      baseQuickAdapter.bindToRecyclerView(recyler_list);
      baseQuickAdapter.setEmptyView(R.layout.base_no_data);
    }
  }

  public void setEmityView(int drawableId) {
    if (baseQuickAdapter != null) {
      baseQuickAdapter.setEmptyView(drawableId);
    }
  }

  public void setEmityView(View view) {
    if (baseQuickAdapter != null) {
      baseQuickAdapter.setEmptyView(view);
    }
  }

  /**
   * 刷新中
   */
  public void refreshing() {
    if (baseQuickAdapter != null && canRefresh) {
      baseQuickAdapter.setEnableLoadMore(false);
    }
  }

  /**
   * 加载中
   */
  public void loading() {
    if (srl_main != null && canLoadMore) {
      srl_main.setEnabled(false);
    }
  }

  /**
   * 刷新或加载完成
   */
  public void compelet() {
    if (srl_main != null && canRefresh) {
      srl_main.setEnabled(true);
      srl_main.setRefreshing(false);
    }
    if (baseQuickAdapter != null && canLoadMore) {
      baseQuickAdapter.setEnableLoadMore(true);
      baseQuickAdapter.loadMoreComplete();
    }
  }

  /**
   * 数据全部加载完毕
   */
  public void setLoadMoreEnd() {
    if (baseQuickAdapter != null) {
      baseQuickAdapter.loadMoreEnd();
    }
  }

  public void setDisableLoadMoreIfNotFullPage() {
    if (baseQuickAdapter != null && recyler_list != null) {
      baseQuickAdapter.disableLoadMoreIfNotFullPage(recyler_list);//默认第一次加载会进入回调，这里设置第一次不需要回调
    }
  }

  /**
   * 数据加载失败
   */
  public void setLoadMoreFail() {
    if (baseQuickAdapter != null) {
      baseQuickAdapter.loadMoreFail();
    }
  }
}
