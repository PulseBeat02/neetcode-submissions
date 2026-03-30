class TimeMap {
public:

    //            key   -> set(pair<value, timestamp>)
    struct Compare {
        bool operator()(const pair<string, int>& first, const pair<string, int>& second) const {
            return first.second > second.second;
        }
    };

    unordered_map<string, std::set<pair<string, int>, Compare>> data;

    TimeMap() {
    }
    
    void set(string key, string value, int timestamp) {
        data[key].insert(make_pair(value, timestamp));
    }
    
    string get(string key, int timestamp) {
        for (pair<string, int> pair : data[key]) {
            if (pair.second <= timestamp) return pair.first;
        }
        return "";
    }
};
