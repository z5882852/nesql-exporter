package com.github.dcysteine.nesql.sql.base.item;

import com.github.dcysteine.nesql.sql.Identifiable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

/** A group of {@link ItemStack}s, all fitting into a single input slot in a recipe. */
@Entity
@EqualsAndHashCode
@ToString
public class ItemGroup implements Identifiable<String> {
    @Id
    @Column(nullable = false)
    private String id;

    @ElementCollection
    private Set<ItemStack> itemStacks;

    /** Needed by Hibernate. */
    protected ItemGroup() {}

    public ItemGroup(String id, Set<ItemStack> itemStacks) {
        this.id = id;
        this.itemStacks = itemStacks;
    }

    @Override
    public String getId() {
        return id;
    }

    public Set<ItemStack> getItemStacks() {
        return itemStacks;
    }
}