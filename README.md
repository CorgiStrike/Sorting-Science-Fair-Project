## Introduction

This is a project created for my Honors Chemistry Science Fair Project. The program creates multiple datasets of varying sizes and sorts them using 10 different sorting algorithms. The datasets range from 10 items to 1,000,000 items, increasing by a factor of 10 each time. The 10 sorting algorithms used were "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Heap Sort", "Counting Sort", "Radix Sort", "Shell Sort", and "Tim Sort".

## More Information on the Algorithims
**Bubble Sort:**
Checks elements next to each other to see if they’re in order, if they aren’t, it swaps them, which it repeats until the dataset is sorted.

**Selection Sort:**
Chooses the smallest element in the unsorted dataset and moves it to the sorted one, which continues until the dataset is sorted.

**Insertion Sort:**
Chooses each element and moves it into its sorted position.

**Merge Sort:**
Splits the data in half, sorts them, then sorts the merged datasets.

**QuickSort:**
Picks a “pivot” element where it sorts the list into numbers less than and greater than the pivot number, then combining them.

**Heap Sort:**
Uses a binary heap to repeatedly extract the maximum element until the dataset is sorted.


**Counting Sort:**
Counts the number of occurrences of an element and then uses the count to sort the dataset. 

**Radix Sort:**
Sorts numbers by processing digits from least to most significant.

**Shell Sort:**
Sorts numbers based on how they are sorted by a “gap”, making it an optimized Insertion Sort.

**Tim Sort:**
A hybrid algorithm between Merge Sort and Insertion Sort, generally regarded as simple and fast.

## Project Findings
All sorters were negligible in time between the 10 and 100 item datasets (considered the small datasets in this experiment). As the size increased to the medium datasets (1,000 and 10,000 items), the inefficiencies of sorters such as Bubble and Selection Sort became apparent, taking miliseconds to complete. Though still a very small amount of time, if the process was to be done repeatedly, it would be better advised to use a different algorithm such as Quicksort. For large datasets (100,000 and 1,000,000 items), the difference between the slowest and fastest sorting algorithms were very apparent. While Quicksort and Counting Sort only took hundredths of a second, Bubble Sort took over 20 minutes to completely sort the dataset. Throughout the experiment, Counting Sort consistently took the least amount of time in the most experiments. This data leads to the conclusion that Counting Sort is the overall most efficient sorting algorithm for datasets between 10 and 1,000,000 items.
