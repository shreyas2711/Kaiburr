import { useState } from "react";
const SearchBar = ({setSearchResults}) => {
    const [query, setQuery] = useState("");

    const search = (e) => {
        e.preventDefault();
        setQuery(e.target.value);
    }

    const ButtonSearch = () => {
        fetch(`http://localhost:9091/tasks/byname/${query}`, {
            method: 'GET',
        })
        .then(response => response.json())
        .then(data => {
            // Handle the search results (update state, etc.)
            setSearchResults(data);
            console.log("Search results:", data);
        })
        .catch(error => {
            console.error("Error searching tasks:", error);
        });
    }

    return (
        <div className="w-full max-w-xl flex mx-auto p-20 text-xl">
            <input
                type="text"
                className="w-full placeholder-gray-400 text-gray-900 p-4"
                placeholder="Search"
                onChange={search}
                value={query}
            />
            <button className="bg-white p-4" onClick={ButtonSearch}>🔍</button>
        </div>
    );
};

export default SearchBar;