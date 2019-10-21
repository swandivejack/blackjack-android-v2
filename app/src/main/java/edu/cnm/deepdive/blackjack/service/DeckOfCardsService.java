package edu.cnm.deepdive.blackjack.service;


import android.content.Context;
import edu.cnm.deepdive.blackjack.R;
import edu.cnm.deepdive.blackjack.model.entity.Card;
import java.net.MalformedURLException;
import java.net.URL;

public interface DeckOfCardsService {

  static DeckOfCardsService getInstance(){
    return InstanceHolder.INSTANCE;
  }

  class InstanceHolder{

    public static final DeckOfCardsService INSTANCE;

    // static initialization
    static {
      // anonymous class instance
      INSTANCE = new DeckOfCardsService() {

        @Override
        public URL getImageUrl(Context context, Card card) {
          try {
            String baseUrl = context.getString(R.string.deck_of_cards_base_url);
            String url = context.getString(R.string.image_url_pattern,baseUrl,card.getAbbreviation());
            return new URL(url);
          } catch (MalformedURLException e) {
            throw new RuntimeException(e);
          }
        }
      };
    }

  }
  URL getImageUrl(Context context, Card card);

}