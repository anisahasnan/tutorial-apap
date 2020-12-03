import React, { useState } from "react";

import List from "./components/List";
import listMovies from "./movies.json";
import "./App.css";

/**
* Building React component using functional programming paradigm
*/

function App() {
// Btw, this is hooks. useState function returns an array
// contains the state and a function to set the state -> [state, setState].
// What you see below is array destruction.
// Let say you have an array const arr = ["aaa", "bbb"], to access the item
// we can use index arr[0] OR destruct it like below
// const [varName, index1] = arr, variable varName is guaranteed to get the value of index 0 OR "aaa"
// here is the illustration for this situation
// below is the return value of useState
// [favItems, setFavItems] = [state, setState]

    const [favItems, setFavItems] = useState(() => []);

    const [toggle, setToggle] = useState(() => false);

    function handleItemAdd(item) {
        // immutability
        const newItems = [...favItems];
        const newItem = { ...item };
        // Find index of item with id
        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        
        if (targetInd < 0) newItems.push(newItem);
 
        // trigger to set a new state
        setFavItems(newItems);
    }

    function handleItemRemove(item) {
        // immutability
        const newItems = [...favItems];
        const newItem = { ...item };
        // Find index of item with id
        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        
        newItems.splice(targetInd, 1); // delete 1 item at index targetInd
 
        // trigger to set a new state
        setFavItems(newItems);
    }

    function removeAllItem() {
        setFavItems([]);
    }

    function showFavorite() {
        setToggle(!toggle);
    }

    return (
        <div className="container-fluid">
            <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
            <p className="text-center text-secondary text-sm font-italic">
                (This is a <strong>function-based</strong> application)
            </p>

            <div class="custom-control custom-switch text-center">
                <input type="checkbox" class="custom-control-input" id="customSwitches2" onClick={showFavorite} /> 
                <label class="custom-control-label" for="customSwitches2">Show Favorites</label>
            </div>

            <div className="container pt-3">
                <div className="row">
                    <div className="col-sm">
                        <List
                            title="List Movies"
                            items={listMovies}
                            onItemClick={handleItemAdd}
                        />
                    </div>
                    
                    { toggle &&
                        <div className="col-sm">
                            <div className="mb-2">
                                {favItems.length > 0 && <button onClick={removeAllItem}>Delete All Favorite Items</button>}
                            </div>
                                                    
                            <List
                                title= "My Favorites"
                                items= {favItems}
                                onItemClick={handleItemRemove}
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
    );
}

export default App;