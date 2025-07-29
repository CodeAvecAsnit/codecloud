def dfs(graph, current_node, goal_node, visited=None, path=None):
    """Perform Depth-First Search (DFS) to find a path from current_node to goal_node."""
    
    # Initialize visited set and path list on the first call
    if visited is None:
        visited = set()
    if path is None:
        path = []
    
    # Mark the current node as visited
    visited.add(current_node)
    path.append(current_node)
    
    # If we find the goal node, return the path
    if current_node == goal_node:
        return path
    
    # Recursively visit all the neighbors of the current node
    for neighbour in graph[current_node]:
        if neighbour not in visited:
            result = dfs(graph, neighbour, goal_node, visited, path)
            if result:  # If a path is found, return it
                return result
    
    # Backtrack by removing the current node from the path
    path.pop()
    return None

# New graph structure (same as before)
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

# Perform DFS and print the result
print("Following is the Depth-First Search path:")
result = dfs(graph, start_node, goal_node)
if result:
    print(" -> ".join(result))  # Join the result list into a string
else:
    print(f"No path found from {start_node} to {goal_node}")
