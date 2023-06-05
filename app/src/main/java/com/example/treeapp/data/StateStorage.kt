package com.example.treeapp.data

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.treeapp.domain.MyNode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class StateStorage(private val context: Application) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("state")
        private val NODE_KEY = stringPreferencesKey("nodeState")
    }

    val getNodes: Flow<MyNode> = context.dataStore.data.map { preferences ->
        Json.decodeFromString(preferences[NODE_KEY] ?: "null")
    }


    suspend fun saveNodes(node: MyNode) {
        context.dataStore.edit { preferences ->
            preferences[NODE_KEY] = Json.encodeToString(node)
        }
    }
}