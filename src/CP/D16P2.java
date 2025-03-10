package CP;

import java.util.Scanner;

/*
In the quiet town of Eldoria, a famous treasure was said to be hidden somewhere, waiting to be discovered.
Many adventurers had tried to find it, but none had succeeded.
One day, two explorers, Arin and Mira, discovered an ancient scroll in the town library.

The scroll contained a long passage filled with cryptic words.
The legend said that the treasure's location could only be revealed if they correctly determined
the shortest distance between two special words in the passage.

They read the passage carefully:
"The old castle stood on the highest hill, where knights once trained with their mighty swords.
A golden key was hidden under the ancient oak tree, and the villagers often spoke of its mysterious glow.
Legends told of a secret passage deep beneath the ground, leading to the lost chest that contained priceless jewels and forgotten artifacts."

Mira pointed at the scroll excitedly. "We need to find the word 'key' and the word 'chest' and count the words between them!"

Arin quickly scanned the passage.
The word "key" appeared at position 19, and the word "chest" was at position 50.
"The shortest distance between them is 30 words!" he exclaimed.

The moment he spoke the answer, the scroll shimmered, and a hidden compartment in the library wall slid open.
Inside, they found an old map leading them to the treasure buried deep within the Whispering Woods.

Their journey had just begun, but thanks to their keen observation and ability to measure the shortest path between two words,
they were one step closer to uncovering Eldoria’s greatest mystery!

Example 1:
Input =apple banana cherry goa apple watermelon juice date
apple date
Output = 2
 */
public class D16P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        //String s2 = sc.nextLine();
        String[] str2 = sc.nextLine().split(" ");
        System.out.println(hunt(str, str2));
    }
    public static int hunt(String[] words, String[] target){
        int ind1 = -1, ind2 = -1;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target[0])) ind1=i;
            else if(words[i].equals(target[1])) ind2=i;
        }
        return Math.abs(ind1-ind2)-1;
    }
}
