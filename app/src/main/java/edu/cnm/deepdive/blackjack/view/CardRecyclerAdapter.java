package edu.cnm.deepdive.blackjack.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.blackjack.R;
import edu.cnm.deepdive.blackjack.model.entity.Card;
import edu.cnm.deepdive.blackjack.service.DeckOfCardsService;
import edu.cnm.deepdive.blackjack.view.CardRecyclerAdapter.CardHolder;
import java.util.List;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardHolder> {

  private final Context context;
  private final List<Card> cards;


  @NonNull
  @Override
  public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.card_list_item, parent, false);
    return new CardHolder(view);
  }

  public CardRecyclerAdapter(Context context, List<Card> cards) {
    this.context = context;
    this.cards = cards;
  }

  @Override
  public void onBindViewHolder(@NonNull CardHolder holder, int position) {
    holder.bind(cards.get(position));
  }

  @Override
  public int getItemCount() {
    return cards.size();
  }

  class CardHolder extends RecyclerView.ViewHolder {

    private final ImageView imageView;
    public CardHolder(@NonNull View itemView) {
      super(itemView);
      imageView = ((ImageView) itemView);
    }

    private void bind(Card card){
      DeckOfCardsService service = DeckOfCardsService.getInstance();
      Picasso.get().load(service.getImageUrl(context,card).toString()).into(imageView);

    }
  }

}
