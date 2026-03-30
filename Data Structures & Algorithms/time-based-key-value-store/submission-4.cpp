class TimeMap {
    unordered_map<string, vector<pair<int, string>>> data;

public:
    TimeMap() {}

    void set(string key, string value, int timestamp) {
        data[key].push_back({timestamp, value}); 
    }

    string get(string key, int timestamp) {
        auto it = data.find(key);
        if (it == data.end()) return "";
        const auto& v = it->second;

        auto ub = upper_bound(
            v.begin(), v.end(),
            timestamp,
            [](int t, const pair<int,string>& p) { return t < p.first; }
        );

        if (ub == v.begin()) return "";
        return prev(ub)->second;
    }
};