package me.cristiangomez.spotifystreamer.app.activity;

import android.content.Intent;
import android.os.Bundle;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.Artist;
import me.cristiangomez.spotifystreamer.R;
import me.cristiangomez.spotifystreamer.app.activity.fragment.SearchArtistFragment;
import me.cristiangomez.spotifystreamer.app.activity.listener.OnArtistSelectedListener;

/**
 * Created by cristian on 07/06/15.
 */
public class SearchArtistActivity extends Base implements OnArtistSelectedListener {
    //========================================================
    //FIELDS
    //========================================================
    //========================================================
    //CONSTRUCTORS
    //========================================================

    //========================================================
    //OVERRIDDEN METHODS
    //========================================================

    @Override
    protected int getLayoutResource() {
        return R.layout.a_search_artist;
    }

    @Override
    protected void initialize(Bundle savedInstance) {
        super.initialize(savedInstance);
        if (savedInstance == null) {
            showSearchArtistFragment();
        }
    }

    @Override
    public void onArtistSelected(Artist artist) {
        Intent intent = new Intent(this, ArtistTopTracksActivity.class);
        intent.putExtra(ArtistTopTracksActivity.cARGS_ARTIST_ID, artist.id);
        startActivity(intent);
    }

    //========================================================
    //METHODS
    //========================================================
    public void showSearchArtistFragment() {
        SearchArtistFragment fragment = new SearchArtistFragment();
        mFragmentManager.beginTransaction().add(R.id.a_search_artist_container,
                fragment).commit();
    }
    //========================================================
    //INNER CLASSES
    //========================================================

    //========================================================
    //GETTERS AND SETTERS
    //========================================================
}