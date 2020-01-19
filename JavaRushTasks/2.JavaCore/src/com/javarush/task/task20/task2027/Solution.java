package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
	public static void main(String[] args) {
		int[][] crossword = new int[][]{
				{'f', 'd', 'e', 'r', 'l', 'k'},
				{'u', 's', 'a', 'm', 'e', 'o'},
				{'l', 'n', 'g', 'r', 'o', 'v'},
				{'m', 'l', 'p', 'r', 'r', 'h'},
				{'p', 'o', 'e', 'e', 'j', 'j'}
		};
		for (Word detectAllWord : detectAllWords(crossword, "home", "same", "kovhj", "plg", "pmluf", "ful")) {
			System.out.println(detectAllWord);
		}
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
	}

	public static List<Word> detectAllWords(int[][] crossword, String... words) {
		List<Word> list = new ArrayList<>(words.length);

		for (String word : words) {
			int head = word.charAt(0);
			int tail = word.length() - 1;

			//find first char
			ffc:
			for (int l = 0; l < crossword.length; l++) {
				for (int c = 0; c < crossword[l].length; c++) {

					if (crossword[l][c] == head) {
						//check on concurrence

						/////////////diagonal
						//forward forward
						dff: if (c + tail < crossword[l].length & l + tail < crossword.length) {
							for (int i = 1; i <= tail; i++) {
								if (crossword[l + i][c + i] != word.charAt(i)) break dff;
							}
							Word newWord = new Word(word);
							newWord.setStartPoint(c, l);
							newWord.setEndPoint(c + tail, l + tail);
							list.add(newWord);
							break ffc;
						}

						//reverse reverse
						drr: if (c - tail >= 0 & l - tail >= 0) {
							for (int i = 1; i <= tail; i++) {
								if (crossword[l - i][c - i] != word.charAt(i)) break drr;
							}
							Word newWord = new Word(word);
							newWord.setStartPoint(c, l);
							newWord.setEndPoint(c - tail, l - tail);
							list.add(newWord);

							break ffc;

						}

						// forward reverse
						dfr: if (c + tail < crossword[l].length & l - tail >=0) {
							for (int i = 1; i <= tail; i++) {
								if (crossword[l - i][c + i] != word.charAt(i)) break dfr;
							}
							Word newWord = new Word(word);
							newWord.setStartPoint(c, l);
							newWord.setEndPoint(c + tail, l - tail);
							list.add(newWord);
							break ffc;
						}
						// reverse forward
						drf: if (c - tail >=0 & l + tail < crossword.length) {
							for (int i = 1; i <= tail; i++) {
								if (crossword[l + i][c - i] != word.charAt(i)) break drf;
							}
							Word newWord = new Word(word);
							newWord.setStartPoint(c, l);
							newWord.setEndPoint(c - tail, l + tail);
							list.add(newWord);
							break ffc;
						}

						////////////horizontal
						//forward
						hf: if (c + tail < crossword[l].length) {
							for (int i = 1; i <= tail; i++) {
								if (crossword[l][c + i] != word.charAt(i)) break hf;
							}
							Word newWord = new Word(word);
							newWord.setStartPoint(c, l);
							newWord.setEndPoint(c + tail, l);
							list.add(newWord);

							break ffc;
						}
						//reverse
						hr: if (c - tail >= 0) {
							for (int i = 1; i <= tail; i++) {
								if (crossword[l][c - i] != word.charAt(i)) break hr;
							}
							Word newWord = new Word(word);
							newWord.setStartPoint(c, l);
							newWord.setEndPoint(c - tail, l);
							list.add(newWord);

							break ffc;
						}


						///////////vertical
						//forward
						vf: if (l + tail < crossword.length) {
							for (int i = 1; i <= tail; i++) {
								if (crossword[l + i][c] != word.charAt(i)) break vf;
							}
							Word newWord = new Word(word);
							newWord.setStartPoint(c, l);
							newWord.setEndPoint(c, l + tail);
							list.add(newWord);

							break ffc;
						}
						//reverse
						vr: if (l - tail >= 0) {
							for (int i = 1; i <= tail; i++) {
								if (crossword[l - i][c] != word.charAt(i)) break vr;
							}
							Word newWord = new Word(word);
							newWord.setStartPoint(c, l);
							newWord.setEndPoint(c, l - tail);
							list.add(newWord);

							break ffc;
						}


					}

				}
			}

		}

		return list;
	}

	public static class Word {
		private String text;
		private int startX;
		private int startY;
		private int endX;
		private int endY;

		public Word(String text) {
			this.text = text;
		}

		public void setStartPoint(int i, int j) {
			startX = i;
			startY = j;
		}

		public void setEndPoint(int i, int j) {
			endX = i;
			endY = j;
		}

		@Override
		public String toString() {
			return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
		}
	}
}
