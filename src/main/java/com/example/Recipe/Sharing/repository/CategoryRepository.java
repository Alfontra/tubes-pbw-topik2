package com.example.Recipe.Sharing.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Recipe.Sharing.model.Category;

@Repository
public class CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // mengembalikan nilai kategori yang di search
    public int countCategories(String keyword) {
        String sql = """
                SELECT COUNT(*)
                FROM categories
                WHERE LOWER(name) LIKE LOWER(?)
                """;
        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                "%" + keyword + "%");

        return count != null ? count : 0;
    }

    // mengembalikan seluruh kategori
    public List<Category> findAll() {
        String sql = "SELECT * FROM categories";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Category category = new Category();

            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));

            return category;
        });
    }

    // mencari kategori
    public List<Category> findCategories(String keyword, String sortDir, int limit, int offset) {
        String direction;

        if (sortDir.equalsIgnoreCase("desc")) {
            direction = "DESC";
        }else{
            direction = "ASC";
        }

        String sql = """
            SELECT id, name
            FROM categories
            WHERE LOWER(name) LIKE LOWER(?)
            ORDER BY name %s
            LIMIT ? OFFSET ?
            """.formatted(direction);

        return jdbcTemplate.query(
            sql,
            (rs, rowNum) -> {
                Category category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                return category;
            },
            "%" + keyword + "%",
            limit,
            offset);
    }

    // memeriksa keberadaan kategori
    public boolean existByName(String name) {
        String sql = "SELECT EXISTS(SELECT 1 FROM categories WHERE name = ?)";

        Boolean exists = jdbcTemplate.queryForObject(
            sql,
            Boolean.class,
            name
        );

        return Boolean.TRUE.equals(exists);
    }

    // menambahkan kategori
    public int save(Category category) {
        String sql = "INSERT INTO categories (name) VALUES ?";

        return jdbcTemplate.update(sql, category.getName());
    }
}
