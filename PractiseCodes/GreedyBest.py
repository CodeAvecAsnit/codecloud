import heapq

# Graph representing the map of cities and their distances to neighbors
graph = { 
    'Arad': {'Zerind': 75, 'Timisoara': 118, 'Sibiu': 140}, 
    'Zerind': {'Arad': 75, 'Oradea': 71}, 
    'Oradea': {'Zerind': 71, 'Sibiu': 151}, 
    'Timisoara': {'Arad': 118, 'Lugoj': 111}, 
    'Lugoj': {'Timisoara': 111, 'Mehadia': 70}, 
    'Mehadia': {'Lugoj': 70, 'Drobeta': 75}, 
    'Drobeta': {'Mehadia': 75, 'Craiova': 120}, 
    'Craiova': {'Drobeta': 120, 'Rimnicu Vilcea': 146, 'Pitesti': 138}, 
    'Sibiu': {'Arad': 140, 'Oradea': 151, 'Fagaras': 99, 'Rimnicu Vilcea': 80}, 
    'Rimnicu Vilcea': {'Sibiu': 80, 'Craiova': 146, 'Pitesti': 97}, 
    'Fagaras': {'Sibiu': 99, 'Bucharest': 211}, 
    'Pitesti': {'Rimnicu Vilcea': 97, 'Craiova': 138, 'Bucharest': 101}, 
    'Bucharest': {'Fagaras': 211, 'Pitesti': 101, 'Giurgiu': 90, 'Urziceni': 85}, 
    'Giurgiu': {'Bucharest': 90}, 
    'Urziceni': {'Bucharest': 85, 'Hirsova': 98, 'Vaslui': 142}, 
    'Hirsova': {'Urziceni': 98, 'Eforie': 86}, 
    'Eforie': {'Hirsova': 86}, 
    'Vaslui': {'Urziceni': 142, 'Iasi': 92}, 
    'Iasi': {'Vaslui': 92, 'Neamt': 87}, 
    'Neamt': {'Iasi': 87} 
}

# Heuristic values (straight-line distances to Bucharest)
heuristic = { 
    'Arad': 366, 'Zerind': 374, 'Oradea': 380, 'Timisoara': 329, 
    'Lugoj': 244, 'Mehadia': 241, 'Drobeta': 242, 'Craiova': 160, 
    'Sibiu': 253, 'Rimnicu Vilcea': 193, 'Fagaras': 178, 'Pitesti': 98, 
    'Bucharest': 0, 'Giurgiu': 77, 'Urziceni': 80, 'Hirsova': 151, 
    'Eforie': 161, 'Vaslui': 199, 'Iasi': 226, 'Neamt': 234 
}

def greedy_best_first_search(graph, start, goal):
    """
    Greedy Best First Search Algorithm to find the path from start to goal node.
    Prioritizes nodes based only on their heuristic (estimated distance to goal).
    """
    # Open list (priority queue) initialized with the start node and its heuristic
    open_list = []
    heapq.heappush(open_list, (heuristic[start], start, []))  # (heuristic_value, current_node, path)
    
    # Closed list to track visited nodes
    closed_list = set()
    
    while open_list:
        # Pop the node with the lowest heuristic value (best guess for goal proximity)
        _, current_node, path = heapq.heappop(open_list)
        
        # Skip the node if it's already been visited
        if current_node in closed_list:
            continue
        
        # Add the current node to the closed list and update the path
        closed_list.add(current_node)
        path = path + [current_node]
        
        # If the goal node is reached, return the path
        if current_node == goal:
            return path
        
        # Explore the neighbors of the current node
        for neighbor in graph[current_node]:
            if neighbor not in closed_list:
                # Push the neighbor to the open list with its heuristic value
                heapq.heappush(open_list, (heuristic[neighbor], neighbor, path))
    
    # Return None if no path is found
    return None

# Execute Greedy Best First Search from 'Arad' to 'Bucharest'
path = greedy_best_first_search(graph, 'Arad', 'Bucharest')

# Output the result
if path:
    print("Path:", " -> ".join(path))
else:
    print("No path found from the start to the goal.")
