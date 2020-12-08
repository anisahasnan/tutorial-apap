import React from "react";

import List from "./components/List";
import listMovies from "./movies.json";
import "./App.css";

export default class App extends React.Component {
  state = {
    favItems: [],
    toggle: false,
    isDarkMode: false,
  }
  
  handleItemAdd = (item) => {
    //Immutability
    const newItems = [ ...this.state.favItems];
    const newItem = { ...item};

    //Find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id)

    if(targetInd < 0) newItems.push(newItem);

    //Trigger set stace
    this.setState({ favItems: newItems});
    
  }

  handleItemRemove = (item) => {
    //Immutability
    const newItems = [ ...this.state.favItems];
    const newItem = { ...item};

    //Find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id)

    newItems.splice(targetInd, 1); //Delete 1 item at index targetInd

    //Trigger set stace
    this.setState({ favItems: newItems});
    
  }

  removeAllItem = () => {
    this.setState({favItems: []});
  }

  showFavorite = () => {
    this.setState({toggle: !this.state.toggle});
  }

  toggleMode = () => {
    this.setState({isDarkMode: !this.state.isDarkMode});

    const { isDarkMode } = this.state;
    localStorage.setItem('isDarkMode', !isDarkMode);
  }

  componentDidMount = () => {
    const isDarkMode = localStorage.getItem('isDarkMode') === 'true';
    this.setState({ isDarkMode });
  }

  render() {
    const { favItems } = this.state;

    return (
      <div>
      { this.state.isDarkMode ?
        <div className="container-fluid" style={{backgroundColor: 'black', color:'white'}}>
          <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
          <p className="text-center text-secondary text-sm font-italic">
            (This is a <strong>class-based</strong> application)
          </p>

          <div class="custom-control custom-switch text-center">
            <input type="checkbox" class="custom-control-input" id="customSwitches" onClick={this.showFavorite} /> 
            <label class="custom-control-label" for="customSwitches">Show Favorites</label>
          </div>

          <div style={{display: 'flex', justifyContent: 'center'}}>
            <input type="checkbox" checked={this.state.isDarkMode} id="customSwitchesdark2" onClick={this.toggleMode} /> 
            <label for="customSwitchesdark2">Dark Mode</label>
          </div>
          
          <div className="container pt-3 ">
            <div className="row">
              <div className="col-sm ">
                <List
                    title="List Movies"
                    items={listMovies}
                    onItemClick={this.handleItemAdd}
                />
              </div>
              
              { this.state.toggle &&
                <div className= "col-sm">
                  <div className="mb-2">
                      {favItems.length > 0 &&
                        <div>
                          <button onClick={this.removeAllItem}>Delete All Favorite Items</button>
                        </div>
                      }
                  </div>
                          
                  <List
                    title= "My Favorites"
                    items= {favItems}
                    onItemClick={this.handleItemRemove}
                  />

                  {favItems.length <= 0 &&
                    <div className="text-center mt-2"> 
                        <h3>Belum ada item yang dipilih</h3>
                        <h4>Klik salah satu item di list movies</h4>
                    </div>
                  }
                </div>
              }
            </div>
          </div>
        </div>
        :
          <div className="container-fluid" style={{backgroundColor: 'white', color:'black'}}>
            <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
            <p className="text-center text-secondary text-sm font-italic">
              (This is a <strong>class-based</strong> application)
            </p>
  
            <div class="custom-control custom-switch text-center">
              <input type="checkbox" class="custom-control-input" id="customSwitches" onClick={this.showFavorite} /> 
              <label class="custom-control-label" for="customSwitches">Show Favorites</label>
            </div>

            <div style={{display: 'flex', justifyContent: 'center'}}>
              <input type="checkbox" checked={this.state.isDarkMode} id="customSwitcheslight2" onClick={this.toggleMode} /> 
              <label for="customSwitcheslight2">Dark Mode</label>
            </div>
            
            <div className="container pt-3 ">
              <div className="row">
                <div className="col-sm ">
                  <List
                      title="List Movies"
                      items={listMovies}
                      onItemClick={this.handleItemAdd}
                  />
                </div>
                
                { this.state.toggle &&
                  <div className= "col-sm">
                    <div className="mb-2">
                        {favItems.length > 0 &&
                          <div>
                            <button onClick={this.removeAllItem}>Delete All Favorite Items</button>
                          </div>
                        }
                    </div>
                            
                    <List
                      title= "My Favorites"
                      items= {favItems}
                      onItemClick={this.handleItemRemove}
                    />
  
                    {favItems.length <= 0 &&
                      <div className="text-center mt-2"> 
                          <h3>Belum ada item yang dipilih</h3>
                          <h4>Klik salah satu item di list movies</h4>
                      </div>
                    }
                  </div>
                }
              </div>
            </div>
          </div>
          }
      </div>
    );
  }
}