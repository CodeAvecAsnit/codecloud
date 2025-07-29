def bfs(graph, start_node, goal_node):
    visited = set()  # To track visited nodes
    queue = []  # To store the nodes to be explored
    
    # If the start and goal nodes are the same, return the start node
    if start_node == goal_node:
        return start_node
    
    visited.add(start_node)  # Mark the start node as visited
    queue.append(start_node)  # Add start node to the queue
    
    while queue:
        # Pop the first element from the queue
        path = queue.pop(0)
        
        # Print the current node followed by an arrow if it's not the goal node
        print(path, end='->' if path != goal_node else '')
        
        # If we reach the goal node, return the path
        if path == goal_node:
            return path
        
        # Explore the neighbors of the current node
        for neighbour in graph[path]:
            if neighbour not in visited:
                visited.add(neighbour)
                queue.append(neighbour)
    
    # If no path is found, return None
    return None

# New graph structure (updated as requested)
graph = {
    'A': ['B', 'C', 'D'],
    'B': ['E', 'F'],
    'C': ['G'],
    'D': ['H'],
    'E': [],
    'F': ['I'],
    'G': [],
    'H': ['J'],
    'I': [],
    'J': []
}

# Define start and goal nodes
start_node = 'A'
goal_node = 'I'

# Print the BFS path result
print("Following is the Breadth-First Search path:")
result = bfs(graph, start_node, goal_node)
print(f"\nGoal node {goal_node} reached: {result}")
