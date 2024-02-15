package com.montaury.pokebagarre.metier;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonTest {

    @Test
    void devrait_etre_vainqueur_s_il_a_une_meilleure_defense() {
        // GIVEN/ARRANGE
        var premier = new Pokemon("Pikachu", "urlImage", new Stats(15,3));
        var second = new Pokemon("Rondoudou", "urlImage2", new Stats(12,7));
        // WHEN/ACT
        var estVainqueur = premier.estVainqueurContre(second);
        // THEN/ASSERT
        assertThat(estVainqueur).isTrue();
    }

    @Test
    void devrait_etre_vainqueur_s_il_a_la_meme_attaque_mais_une_meilleure_defense() {
        // GIVEN/ARRANGE
        var premier = new Pokemon("Pikachu", "urlImage", new Stats(12,3));
        var second = new Pokemon("Rondoudou", "urlImage2", new Stats(12,7));
        // WHEN/ACT
        var estVainqueur = premier.estVainqueurContre(second);
        // THEN/ASSERT
        assertThat(estVainqueur).isFalse();
    }

    @Test
    void le_premier_pokemon_renseigne_devrait_etre_le_vaiqueur_si_meme_attaque_et_meme_defense() {
        // GIVEN/ARRANGE
        var premier = new Pokemon("Pikachu", "urlImage", new Stats(12,3));
        var second = new Pokemon("Rondoudou", "urlImage2", new Stats(12,3));
        // WHEN/ACT
        var estVainqueur = premier.estVainqueurContre(second);
        // THEN/ASSERT
        assertThat(estVainqueur).isTrue();
    }
}