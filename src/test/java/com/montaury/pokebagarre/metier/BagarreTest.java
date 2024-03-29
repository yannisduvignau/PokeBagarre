package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.erreurs.ErreurMemePokemon;
import com.montaury.pokebagarre.erreurs.ErreurPokemonNonRenseigne;
import com.montaury.pokebagarre.webapi.PokeBuildApi;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class BagarreTest {
    PokeBuildApi fausseApi;
    Bagarre bagarre;

    @BeforeEach
    void preparer(){
        fausseApi = mock(PokeBuildApi.class);
        bagarre = new Bagarre(fausseApi);
    }
    @Test
    void le_premier_poke_renseigne_est_null(){
        //GIVEN
        Bagarre bagarre = new Bagarre();
        // WHEN/ACT
        Throwable thrown = Assertions.catchThrowable(() -> bagarre.demarrer(null,"pikatchu"));
        // THEN/ASSERT
        assertThat(thrown)
         .isInstanceOf(ErreurPokemonNonRenseigne.class)
         .hasMessage("Le premier pokemon n'est pas renseigne");
    }

    @Test
    void le_deuxieme_poke_renseigne_est_null(){
        //GIVEN
        Bagarre bagarre = new Bagarre();
        // WHEN/ACT
        Throwable thrown = Assertions.catchThrowable(() -> bagarre.demarrer("pikatchu",null));
        // THEN/ASSERT
        assertThat(thrown)
                .isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le second pokemon n'est pas renseigne");
    }

    @Test
    void le_premier_poke_renseigne_est_vide(){
        //GIVEN
        Bagarre bagarre = new Bagarre();
        // WHEN/ACT
        Throwable thrown = Assertions.catchThrowable(() -> bagarre.demarrer("","pikatchu"));
        // THEN/ASSERT
        assertThat(thrown)
                .isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le premier pokemon n'est pas renseigne");
    }

    @Test
    void le_deuxieme_poke_renseigne_est_vide(){
        //GIVEN
        Bagarre bagarre = new Bagarre();
        // WHEN/ACT
        Throwable thrown = Assertions.catchThrowable(() -> bagarre.demarrer("pikatchu",""));
        assertThat(thrown)
                .isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le second pokemon n'est pas renseigne");
    }

    @Test
    void les_deux_pokes_renseignes_sont_null(){
        //GIVEN
        Bagarre bagarre = new Bagarre();
        // WHEN/ACT
        Throwable thrown = Assertions.catchThrowable(() -> bagarre.demarrer(null,null));
        // THEN/ASSERT
        assertThat(thrown)
                .isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le premier pokemon n'est pas renseigne");
    }

    @Test
    void les_deux_pokes_renseignes_sont_vide(){
        //GIVEN
        Bagarre bagarre = new Bagarre();
        // WHEN/ACT
        Throwable thrown = Assertions.catchThrowable(() -> bagarre.demarrer("",""));
        // THEN/ASSERT
        assertThat(thrown)
                .isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le premier pokemon n'est pas renseigne");
    }

    @Test
    void les_deux_pokes_renseignes_ont_le_meme_nom(){
        //GIVEN
        Bagarre bagarre = new Bagarre();
        // WHEN/ACT
        Throwable thrown = Assertions.catchThrowable(() -> bagarre.demarrer("pikatchu","pikatchu"));
        // THEN/ASSERT
        assertThat(thrown)
                .isInstanceOf(ErreurMemePokemon.class)
                .hasMessage("Impossible de faire se bagarrer un pokemon avec lui-meme");
    }

    /*2situations appel methode recurpererNom:pb recuperation1 et 2 pokemon;recup se passe bien ...*/
}