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

def a_star_search(graph, start, goal):
    """
    A* Search Algorithm to find the optimal path from start to goal node.
    Uses a priority queue (min-heap) to prioritize the exploration of nodes.
    """
    # Priority queue (min-heap) for exploring the nodes: (f_score, g_score, current_node, path)
    open_list = []
    heapq.heappush(open_list, (0 + heuristic[start], 0, start, []))  # (f_score, g_score, current_node, path)
    
    # Set to track visited nodes
    visited = set()
    
    while open_list:
        # Pop the node with the lowest f_score (priority)
        _, g_score, current_node, path = heapq.heappop(open_list)
        
        # Skip the node if it's already visited
        if current_node in visited:
            continue
        
        # Mark the current node as visited and add it to the path
        visited.add(current_node)
        path = path + [current_node]
        
        # If the goal node is reached, return the path and its total cost
        if current_node == goal:
            return path, g_score
        
        # Explore the neighbors of the current node
        for neighbor, distance in graph[current_node].items():
            if neighbor not in visited:
                # Calculate the g_score (cost to reach the neighbor)
                total_g_score = g_score + distance
                # Calculate f_score = g_score + heuristic (estimated cost to goal)
                total_f_score = total_g_score + heuristic[neighbor]
                # Push the neighbor to the priority queue
                heapq.heappush(open_list, (total_f_score, total_g_score, neighbor, path))
    
    # Return None if no path is found
    return None, None

# Execute A* search from 'Oradea' to 'Vaslui'
path, cost = a_star_search(graph, 'Oradea', 'Vaslui')

# Output the result
if path:
    print("Optimal Path:", " -> ".join(path))
    print("Total Cost:", cost)
else:
    print("No path found from the start to the goal.")
