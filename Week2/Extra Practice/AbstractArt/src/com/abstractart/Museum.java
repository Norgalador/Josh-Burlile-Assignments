package com.abstractart;

import java.util.ArrayList;
import java.util.Collections;

import com.abstractart.Painting;
import com.abstractart.Sculpture;

public class Museum {

	public static void main(String[] args) {

		ArrayList<Art> museum = new ArrayList<Art> ();
		museum.add(new Painting("The Great Wave off Kanagawa", "Hokusai", "A big wave threatens three fishing boats on the coast", "oil on canvas"));
		museum.add(new Painting("Mona Lisa", "Leonardo da Vinci", "Woman named Mona smiles for a portrait", "oil painting"));
		museum.add(new Painting("The Scream", "Edvard Munch", "Man screaming with blood orange/red sunlight in the background", "Oil painting"));
		museum.add(new Sculpture("Apollo Belvedere", "unknown", "Greek god Apollo depeicted as an archer releasing an arrow", "white marble"));
		museum.add(new Sculpture("David", "Michaelangelo", "Biblical character of David stands nude", "marble sculpture"));
		
		Collections.shuffle(museum);
		
		for(Art artwork : museum) {
			artwork.viewArt();
		}
		
	}


}
