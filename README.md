# To-Do-List
This project enables us to create a list of tasks that we intend to accomplish, facilitating the organization of our time. As evident in this web application, it encompasses features such as adding, searching, sorting (including reverse sorting), and deleting tasks.
![image](https://github.com/zhalgas-seidazym/to-do-list/assets/124429967/e2531417-9c32-46dc-a372-99bc114908fa)

![image](https://github.com/zhalgas-seidazym/to-do-list/assets/124429967/8c39820a-c09b-4e4a-b541-639c23740c88)

In this project, I implemented sorting algorithms such as bubble sort and selection sort, as well as linear search. I opted for these algorithms over faster ones because they are more straightforward, and our dataset is not large enough to necessitate more complex algorithms.

Upon launching the application, I retrieve information from the ArrayList<Task> stored in a .txt file and display it. When we want to view the list of tasks sorted by date and time, starting from the nearest to us, bubble sort comes into play. By swapping tasks based on their date and time, it provides us with an ArrayList<Task> sorted from the closest to the furthest task.

For those instances where we wish to see tasks arranged from the farthest to the nearest, selection sort proves useful. It selects the farthest task and inserts it forward, repeating this process to yield an ArrayList<Task> sorted from the farthest to the nearest task.

When it comes to searching by time, linear search is employed. By checking each task in the ArrayList<Task> for time compatibility, it returns tasks that need to be performed at that specific time.
