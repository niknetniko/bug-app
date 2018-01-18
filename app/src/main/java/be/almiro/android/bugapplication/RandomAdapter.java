package be.almiro.android.bugapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

/**
 * @author Niko Strijbol
 */
public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.ViewHolder> {

    private Random random = new Random();

    private static final int SHORT = 1;
    private static final int LONG = 2;

    private int[] types;

    public RandomAdapter() {
        types = new int[getItemCount()];
        for (int i = 0; i < getItemCount(); i++) {
            types[i] = random.nextInt(50) < 25 ? SHORT : LONG;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LONG) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false));
        } else if (viewType == SHORT) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_big, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //nothing
    }

    @Override
    public int getItemCount() {
        return 200;
    }

    @Override
    public int getItemViewType(int position) {
        return types[position];
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}