package be.almiro.android.bugapplication;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

/**
 * Add spacing to elements for a staggered grid. This will insert spacing on the right of every element, except for the
 * last span column.
 *
 * If the layout manager is not a {@link StaggeredGridLayoutManager} or {@link GridLayoutManager}, this will do nothing.
 *
 * @author Niko Strijbol
 */
public class SpanItemSpacingDecoration extends RecyclerView.ItemDecoration {

    private final int spacing;

    public SpanItemSpacingDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, final View view, final RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        //If this is not supported, do nothing. Otherwise extract the span.
        if (!(parent.getLayoutManager() instanceof StaggeredGridLayoutManager || parent.getLayoutManager() instanceof GridLayoutManager)) {
            return;
        }

        final int itemSpan;
        final int spanCount;

        if (parent.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            itemSpan = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
            spanCount = ((StaggeredGridLayoutManager) parent.getLayoutManager()).getSpanCount();
            if (itemSpan == StaggeredGridLayoutManager.LayoutParams.INVALID_SPAN_ID) {
                Log.e("DECOR", "NOOOOOOOOOOOOOOOOOO");
            }
        } else {
            itemSpan = ((GridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
            spanCount = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();
        }

        //If this is the last span, do nothing.
        if (itemSpan < spanCount - 1) {
            outRect.right = spacing;
        } else {
            outRect.right = 0;
        }
    }
}