public enum UserRoles {

        HUISARTS,
        APOTHEKER,
        FYSIOTHERAPEUT,
        TANDARTS;

        public boolean canViewMedication() {
            return this != TANDARTS;
        }
        public boolean canAddMedication() {
                return this == HUISARTS || this == APOTHEKER;
        }
        public boolean canUpdateMedication() {
                return this == HUISARTS;
        }
        public boolean canViewPainkillersOnly() {
                return this == FYSIOTHERAPEUT;
        }
        public boolean canWriteConsult() {
                return this == HUISARTS || this == FYSIOTHERAPEUT;
        }
        public boolean canViewConsults() {
                return this == HUISARTS || this == FYSIOTHERAPEUT;
        }
}
