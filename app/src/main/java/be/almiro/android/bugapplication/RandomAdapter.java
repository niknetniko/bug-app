package be.almiro.android.bugapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == LONG) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false));
        } else if (viewType == SHORT) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_big, parent, false));
        }
        throw new IllegalArgumentException("Type not known: " + viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //nothing
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return random.nextInt(2) < 1 ? SHORT : LONG;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}