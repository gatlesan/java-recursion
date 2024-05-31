package striver_sheet.stack_and_queue;

public class MinTimeToRotAllOranges {

    // Breadth - width - thickness - same level distance from a given point
    // Breadth first search (or) Level wise traversal
    // Depending on starting node level changes,
    // From starting node(level 0) nodes distant in 1 are at level 1 and nodes distant in 2
    // are at level 2 and so on...
    // Visiting order changes when starting node is changed

    // starting configuration of the BFS traversal
    // 1. visited array 1d or 2d based on the problem
    // 2. queue

    // to start with you will have starting node in the queue
    // 1. pop
    // 2. update visited
    // 3. push adjacent of popped in queue
    // repeat
}
