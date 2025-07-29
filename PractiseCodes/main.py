class WaterJug():
    def __init__(self,j1max=None,j2max=None,x=None,y=None):
      self.j1max=4
      self.j2max=3
      self.x=0
      self.y=0

    def Rules(self):
      print()
      print("Rule 1 : fill X")
      print("Rule 2 : fill Y")
      print("Rule 3 : empty X")
      print("Rule 4 : empty Y")
      print("Rule 5 : fill y from X")
      print("Rule 6 : fill x from y ")
      print("Rule 7 : empty X into Y")
      print("Rule 8 : empty Y inot X ")
      rule= int(input("Enter the rule : "))
      return rule
    
    def solve(self):
     steps = 0
     while True:
        print(f"Current state - Jug X: {self.x} Jug Y: {self.y}")
        
        if (self.x == 2 and self.y == 0) or (self.y == 2 and self.x == 0):
            print()
            print()
            print("Successfully have a jug with 2 liters")
            print(f"Final state - Jug X: {self.x} Jug Y: {self.y}")
            print(f"Solution found in {steps} steps!")
            break
        
        self.cases(self.Rules())
        steps +=1
        
        if steps > 100:
            print("Solution not found in 100 steps. Stopping.")
            break

    def cases(self,num):
      match num:
        case 1:
          self.x = self.j1max
        
        case 2:
          self.y = self.j2max

        case 3:
          self.x = 0

        case 4:
          self.y = 0

        case 5:
          if(self.x+self.y>self.j2max):
            temp = self.y;
            self.y = self.j2max
            self.x = self.x + temp - self.y
          else:
            self.y += self.x
            self.x = 0


        case 6:
          if(self.x+self.y>=self.j1max):
            temp = self.x;
            self.x = self.j1max
            self.y = self.y+temp - self.x
          else:
            self.x+=self.y
            self.y = 0
            
            

        case 7:
          if(self.x+self.y<=3)and(self.x>0):
            self.x = 0
            self.y = self.x+self.y
        
        case 8:
          if(self.x+self.y<=4):
            self.y = 0
            self.x = self.x+self.y
        
        case default:
          print("Please Enter a valid rule.")

print("This is a water jug problem solver")
JugX = WaterJug()
JugX.solve()
    



    
