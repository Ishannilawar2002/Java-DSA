# Java Syntax Cheatsheet
(Add a new entry every time you learn a new pattern. Quick lookup, not a textbook.)

---

## HashSet
```java
HashSet<Integer> set = new HashSet<>();
set.add(x);            // add a value
set.contains(x);       // true/false, is x in the set?
```
Use when: you only need to check "have I seen this?" — no counting, no extra data.

---

## HashMap
```java
HashMap<Character, Integer> map = new HashMap<>();
map.put(key, value);              // set/overwrite value for key
map.get(key);                     // returns value, or null if key missing
map.getOrDefault(key, 0);         // returns value, or 0 (safe fallback) if key missing
map.containsKey(key);             // true/false, does this key exist?
map.containsValue(value);         // true/false, does this value exist anywhere (rarely used, slow)
map.values();                     // Collection of just the values (loop with for-each)
map.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
    // if key missing: create new ArrayList, store it, then add item to it
    // if key exists: just grab existing list and add item to it
```
Use when: you need key → value lookups (counts, indices, grouping, etc).

⚠️ `map.get(missingKey)` returns `null`, NOT 0. `null + 1` crashes (NullPointerException).
Always use `getOrDefault(key, 0)` when doing math on a possibly-missing key.

---

## Frequency counting pattern (Valid Anagram)
```java
for (char c : s.toCharArray()) {
    count.put(c, count.getOrDefault(c, 0) + 1);
}
```

---

## Two Sum pattern — check complement BEFORE adding
```java
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
    }
    map.put(nums[i], i);
}
```
Key insight: check first, store second — turns O(n²) brute force into O(n).

---

## Sorting a string (get anagram "fingerprint")
```java
char[] chars = word.toCharArray();
Arrays.sort(chars);              // sorts in place
String sorted = new String(chars);  // convert back to String
```
Anagrams always produce the same sorted string — use as a HashMap key to group them.

---

## static keyword
`static` = belongs to the CLASS itself, not to an object/instance.
- No need to create an object first — call directly: `ClassName.methodName()`
- `main` is always static (Java calls it before any object exists)
- A static method can only directly call other static methods

---

## List vs ArrayList
`List` = interface (a contract/promise of behavior). Can't instantiate directly.
`ArrayList` = actual class that implements List.
Convention: `List<String> names = new ArrayList<>();`
(declare as the interface, create as the implementation — flexible if you swap implementations later)

---

## Big-O reminders
- Nested loop (each ~n times) → O(n²), NOT factorial. Factorial is for permutations/orderings.
- Comparing every pair of n items with a check that costs k each → O(n² × k)
- HashSet/HashMap operations (get/put/contains) → O(1) average
- Big-O ignores constants and lower-order terms: (n² - n)/2 → still O(n²)

